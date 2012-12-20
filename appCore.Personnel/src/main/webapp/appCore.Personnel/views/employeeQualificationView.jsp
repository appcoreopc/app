    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />


        <script language="javascript" src="../../js/coreDataSourceHelper.js"></script>
        <script language="javascript" src="../../js/coreListView.js"></script>

        <link href="../../kendo/styles/kendo.custom.min.css" rel="stylesheet">

        <script type="text/x-kendo-tmpl" id="employeeQualificationTemplate">

        <div class="formRowView">
        <div class="viewLabelSection">Level</div><div class="inputSection">#=level#</div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">Field</div><div class="inputSection">Field</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Major</div><div class="inputSection">Major</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Institution</div><div class="inputSection">Institution</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Local/Oversea</div><div class="inputSection">Local/Oversea</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Start Date</div><div class="inputSection">Start Date</div>
        </div>

        <div class="formRowView">
        <div class="viewLabelSection">End Date</div><div class="inputSection">End Date</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Result (CGPA) </div><div class="inputSection">CGPA</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Attachment</div><div class="inputSection">Attachment</div>
        </div>


        <div class="formRowView">
        <div class="viewLabelSection">Remarks</div><div class="inputSection">QualificationRemark</div>
        </div>

        <div class="formRowView">
        <span class="formRowRuler"></span>
        </div>


        </script>


        <script type="text/javascript">


        $(document).ready(function()
        {

        var ajaxCore = new AjaxCore();
        var request = ajaxCore.sendRequest(globalEmployeeQualificationListUrl, null, "get");

        request.success(function(dataSource)
        {
        var coreListView = new CoreListView();
        coreListView.createListView("qualificationDataContent", dataSource, "employeeQualificationTemplate");
        });

        });

        </script>

        <div id="qualificationDataContent"></div>
