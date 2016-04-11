package Exceptions._3_three_resources_____;


public class AnswerThreeResourcesJava6 {
    public static void call(AutoCloseableFactory factoryA,AutoCloseableFactory factoryB,
                            AutoCloseableFactory factoryC,TryBody body) throws Throwable {

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
        // if A and B initialized
        // Create C
        AutoCloseable resourceC;
        try{
            resourceC=factoryC.create();
        }catch (Throwable FailCreateC){
         // try to close A and B
            try{
                resourceB.close();
            }catch (Throwable FailCloseB){
                FailCreateC.addSuppressed(FailCloseB);
         // if B(createC) broke then try to close A
                try{
                    resourceA.close();
                }catch (Throwable FailCloseA){
                 FailCreateC.addSuppressed(FailCloseA);
                }
                throw FailCreateC;
            }
         // if B close  normally - close A
            try{
                resourceA.close();
            }catch (Throwable FailCloseA){
                FailCreateC.addSuppressed(FailCloseA);
            }
            throw FailCreateC;
        }

    // If A,B,C initialized try to runBody
        try {
            body.runBody();
        }catch (Throwable runBodyFail){
    // need to close A,B,C
            try {
                resourceC.close();
            }catch (Throwable FailCloseC){
                runBodyFail.addSuppressed(FailCloseC);
                try {
                 resourceB.close();
                }catch (Throwable FailCloseB){
                    runBodyFail.addSuppressed(FailCloseB);
                    try{
                        resourceA.close();
                    }catch (Throwable FailCloseA){
                        runBodyFail.addSuppressed(FailCloseA);
                    }
                    throw runBodyFail;
                }
                resourceA.close();
                throw runBodyFail;
            }
    // if C normally close try to close A,B
            try{
                resourceB.close();
            }catch (Throwable FailCloseB){
                runBodyFail.addSuppressed(FailCloseB);
                try {
                    resourceA.close();
                }catch (Throwable FailCloseA){
                    runBodyFail.addSuppressed(FailCloseA);
                }
                throw runBodyFail;
            }
    // if B,C closed normally try to close A
            try {
                resourceA.close();
            }catch (Throwable FailCloseA){
                runBodyFail.addSuppressed(FailCloseA);
            }
            throw runBodyFail;
        }
    // if runBody good - try to close A,B,C normally
        try{
            resourceC.close();
        }catch (Throwable FailCloseC){
        // if C close bad try to close A,B
              try{
                  resourceB.close();
              }catch (Throwable FailCloseB){
                  FailCloseC.addSuppressed(FailCloseB);
              // if B,C close bad try to close A
                  try{
                      resourceA.close();
                  }catch (Throwable FailCloseA){
                      FailCloseC.addSuppressed(FailCloseA);
                  }
                  throw FailCloseC;
              }
             // if B close good
              try{
                  resourceA.close();
              }catch (Throwable FailCloseA){
                  FailCloseC.addSuppressed(FailCloseA);
              }
            throw FailCloseC;
        }
    // if C close good - try to close A,B
        try{
            resourceB.close();
        }catch (Throwable FailCloseB){
            try {
                resourceA.close();
            }catch (Throwable FailCloseA){
                FailCloseB.addSuppressed(FailCloseA);
            }
            throw FailCloseB;
        }
        // if B,C closed normally try to close A
        resourceA.close();
    }
}