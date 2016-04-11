package Exceptions._2_two_resources_____;

public class AnswerTwoResourcesJava6 {
    public static void call( AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body)
    throws Throwable {
       // Create A
       AutoCloseable resourceA= factoryA.create();
       // Create B
       AutoCloseable resourceB;
               try{
                   resourceB  = factoryB.create();
               }catch (Throwable FailCreateB){
       // Close A  if B initialized bad
                    try{
                     resourceA.close();
                    }catch (Throwable FailCloseA){
                     FailCreateB.addSuppressed(FailCloseA);
                    }
                 throw FailCreateB;
               }

       // Run Body  if A and B initialized
               try{
                   body.runBody();
               } catch (Throwable runBodyFail){
       // Close B  if body broke
                   try{
                       resourceB.close();
                   } catch (Throwable FailCloseB){
                     runBodyFail.addSuppressed(FailCloseB);
       // Close A if B(and runBody) broke
                       try {
                        resourceA.close();
                       }catch (Throwable FailCloseA){
                         runBodyFail.addSuppressed(FailCloseA);
                       }
                      throw runBodyFail;
                   }
       // Close A if B close good
                   try {
                       resourceA.close();
                   }catch (Throwable FailCloseA){
                       runBodyFail.addSuppressed(FailCloseA);
                   }
                   throw runBodyFail;
               }

       // try to close B and then A normally

       // if B broke
                try {
                    resourceB.close();
                } catch (Throwable FailCloseB){
       // try to close A
                     try{
                         resourceA.close();
                     }catch (Throwable FailCloseA){
                        FailCloseB.addSuppressed(FailCloseA);
                     }
                  throw FailCloseB;
                }
                resourceA.close();
    }
}