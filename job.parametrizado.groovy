job ("ejemplo2-job-DSL"){
  	description("Job DSL de ejemplo para el curso")
  scm {
    git("https://github.com/macloujulian/jenkins.job.parametrizado.git","main"){ node->
     node / gitConfigName("codigoartesano")
      node / gitConfigEmail("dinolabsmx@gmail.com")
       }
    }
   parameters {
  		stringParam('nombre', defaultValue='julian', description = ' de cadena para job boobleano')
        choiceParam('planeta',['tierra','marte','jupiter','urano','venus','saturno',])
        booleanParam('agente',false)
    }
   triggers {
    	cron(' H/7 * * * *')
   }
   steps {
  		shell("bash jobscript.sh")
   }
   publishers {
  		mailer('marcomtzg@gmail.com', true, true)
 		    slackNotifier{
   				notifyAborted(true)
              	notifyEveryFailure(true)
              	notifyNotBuilt(false)
              	notifyUnstable(false)
              	notifyBackToNormal(true)
              	notifySuccess(false)
              	notifyRepeatedFailure(false)
              	startNotification(false)
                includeTestSummary(false)
              	includeCustomMessage(false)
              	customMessage(null)
                sendAs(null)
              	commitInfoChoice('NONE')
              	teamDomain(null)
              	authToken(null)
            }
   }
  }
