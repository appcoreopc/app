import com.appCore.reportingService.Core.RunnableReport

class TestReport implements RunnableReport
{
   int getReportStatus()
   {
      return 999
   }
    
   int executeReport()
   {
     return 888
   }
}