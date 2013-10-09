    <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/companyHelper.js"></script>
        <script language="javascript" src="../../js/viewmodal/codeMaintenanceAddUpdateViewModel.js"></script>
        <script language="javascript" src="../../js/bootstrap.min.js"></script>



        <script type="text/html" id="companyEntityAddTemplate">

        <div class="form">

        <div class="formMainContent">

        <div class="sectionalFormHeader">Maintenance code</div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>Code</div><div
        class="inputSectionBlock"><input
        class="validate[required, maxSize[10]]" type="text" data-bind="codepicker : name, codeEntity : { codeType : 14,
        companyId : $root.globalViewModel.companyId() }"
        id="BranchCode" name="BranchCode" placeholder="a new branch code" /></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" data-bind="checked : disabled" /></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>Description</div><div
        class="inputSectionBlock"><input
        type="text" class="validate[required, maxSize[80]]" data-bind="value : description" id="description" placeholder="code description"/></div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>Start Effective Date</div><div
        class="inputSectionBlock"><input
        type="text" class="validate[required, maxSize[80]]" data-bind="datepicker: startEffectiveDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : startEffectiveDate, enable : !disabled()" id="startEffectiveDate" placeholder="start effective date"/></div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>End Effective Date</div><div
        class="inputSectionBlock"><input
        type="text" class="validate[required, maxSize[80]]" data-bind="datepicker: endEffectiveDate, datepickerOptions: { dateFormat :
        'dd-mm-yy'}, value : endEffectiveDate, enable : !disabled()" id="endEffectiveDate" placeholder="end effective date"/></div>
        </div>


        <div> <div class="maintenanceCommandSpace"></div>
        <div id="branchCommand" class="maintenanceCommand">
        <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
        class="command">Save</button>
        <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>

        </div>
        </div>

        </div>

        <div>&nbsp;
        </div>

    </script>

        <script type="text/javascript">

        var vm;
        var formName = "codeForm";

        $(document).ready(function()
        {
            var codeType = parseInt(globalCodeMaintenance);
            $.when(init()).done(bind());

            function init()
            {
                 vm = new CodeMaintenanceAddUpdateViewModel(codeType, globalViewModel);
            }

            function bind()
            {
                $("#" + formName).setupViewBinding(vm, globalViewModel);
                $("#accordian").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
            }
        });

        </script>

        <form id="codeForm">

        <div id="codeMaintenance" data-bind="template : { name : templateToUse} ">
        </div>
        </form>