    <style>
        body { font-family: arial; font-size: 14px; }

        .liveExample { padding: 1em; background-color: #EEEEDD; border: 1px solid #CCC; max-width: 655px; }
        .liveExample input { font-family: Arial; }
        .liveExample b { font-weight: bold; }
        .liveExample p { margin-top: 0.9em; margin-bottom: 0.9em; }
        .liveExample select[multiple] { width: 100%; height: 8em; }
        .liveExample h2 { margin-top: 0.4em; }


        .ko-grid { margin-bottom: 1em; width: 25em; border: 1px solid silver; background-color:White; }
        .ko-grid th { text-align:left; background-color: Black; color:White; }
        .ko-grid td, th { padding: 0.4em; }
        .ko-grid tr:nth-child(odd) { background-color: #DDD; }
        .ko-grid-pageLinks { margin-bottom: 1em; }
        .ko-grid-pageLinks a { padding: 0.5em; }
        .ko-grid-pageLinks a.selected { background-color: Black; color: White; }
        .liveExample { height:20em; overflow:auto } /* Mobile Safari reflows pages slowly, so fix the height to avoid
        the need for reflows */

        li { list-style-type: disc; margin-left: 20px; }
        ​

        </style>

        <script language="javascript" src="../../js/viewmodal/branchViewModel.js"></script>
        <script src="../../js/ajaxCore.js"></script>
        <script src="../../js/appDefinition.js"></script>
        <script src="../../js/jquery-1.7.2.min.js"></script>
        <script language="javascript" src="../../js/viewmodal/knockoutBindersControl.js"></script>
        <script language="javascript" src="../../js/knockoutjs/knockout-2.2.0.debug.js"></script>
        <script language="javascript" src="../../js/testGrid.js"></script>
        <script language="javascript" src="../../js/viewmodal/employeeHelper.js"></script>


        <script type="text/javascript">
        $(document).ready(function()
        {

            var ajaxCore = new AjaxCore();
            var fieldRequest = ajaxCore.sendRequest("http://localhost:8080/appCore-personnel/app/Core/Branch/edit", null, "get");
            fieldRequest.success(function (data, status, xhrObj) {
                console.log(data);
            });







        var SimplePage = function()
        {
            var self = this;

            self.code = ko.observable();
        }

        var vm = new SimplePage();
        ko.applyBindings(vm);

        });

        </script>

        <input type="text" data-bind="codepicker : code, codeEntity : { codeType : 1, companyId : '1' }" />

