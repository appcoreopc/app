        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />

        <script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/branchInfoViewModel.js"></script>
        <script language="javascript" src="../../js/bootstrap.min.js"></script>


        <script type="text/html" id="infoUpdateTemplate">


            <div class="formRowList">

            <span class='columnDivider'>
            <span class="labelSectionInfo">Category</span>
            <span class="inputSectionForm"><input type="text" data-bind="value : $root.infoCategory" class="validate[required, maxSize[10]]" placeholder="info type"/></span>

            </span>

            <span class='columnDivider'>
            <span class="labelSectionInfo">Description</span></span>
            <span class="inputSectionForm">
            <input type="text" data-bind="value : $root.infoDescription" placeholder="new description"/></span>
            </span>


            <span class='columnDivider'>
            <span class="labelSectionInfo">Type</span></span>
            <span class="inputSectionForm">
            <input type="text" data-bind="value : $root.infoType" placeholder="type"/></span>
            </span>

            <span class='columnDivider'>
            <span class="labelSectionInfo">Value</span>
            <span class="inputSectionForm">
            <input type="text" data-bind="value : $root.infoValue" placeholder="new value"/></span>
            </span>

            <span class="formRowCommand">
            <span class="labelSectionCommand"></span>
            <span class="inputSectionForm">
            <button id="updateBtn" type="button" data-bind="visible : $root.enableUpdate, click : $root.updateInfoData"
            class="command">Update</button>

            <button id="cancelUpdateBtn" type="button" data-bind="visible : $root.enableUpdate, click : $root.cancelInfoData"
            class="command">Cancel</button>

            </span>
            </span>

            </div>

            <span class="formRowSpacer">
            </span>



            </script>

            <script type="text/html" id="infoViewTemplate">

            <div class="formRowList">
                <span class='columnDividerListView' data-bind="text : infoCategory"></span>
                <span class='columnDividerListView' data-bind="text : infoDescription"></span>
                <span class='columnDividerListView' data-bind="text : infoType"></span>
                <span class='columnDividerListView' data-bind="text : infoValue"></span>
                <span class='columnDividerListViewCmd'><a href="#" data-bind="visible : $root.enableUpdate, click : $root.editInfoData">Edit</a></span>
                <span class='columnDividerListViewCmd'><a href="#" data-bind="visible : $root.enableDelete, click : $root.deleteInfoData">Delete</a></span>
            </div>

            </script>








            <script type="text/html" id="infoAddTemplate">


            <span class="accordianRowHeader"><icon class="icon-plus-circle-1"></icon></span>


            <div class="formAddRow">

                <div class='columnDivider'>
                    <div class="labelSectionInfo">Category</div>
                    <div class="inputSectionForm"><input id="branchCategoryAdd" type="text"  data-bind="value : $root.addInfoCategory" placeholder="category type" class="validate[required, maxSize[10]]"/></div>

                </div>

                <div class='columnDivider'>
                    <div class="labelSectionInfo">Description</div><span class='req'>*</span>
                    <div class="inputSectionForm">
                    <input type="text" id="branchDescriptionAdd" data-bind="value : $root.addInfoDescription" placeholder="new description"/></div>
                </div>


                <div class='columnDivider'>
                    <div class="labelSectionInfo">Type</div><span class='req'>*</span>
                    <div class="inputSectionForm">
                    <input type="text" id="branchTypeAdd" data-bind="value : $root.addInfoType" placeholder="new type" class="validate[required, maxSize[10]]"/></div>
                </div>

                <div class='columnDivider'>
                    <div class="labelSectionInfo">Value</div><span class='req'>*</span>
                    <div class="inputSectionForm">
                    <input type="text" data-bind="value : $root.addInfoValue" placeholder="new value"/></div>
                </div>

            <span class="formAddRowCommand">
                <button id="addBtn" type="button" data-bind="visible: $root.enableAdd, click: addInfo" class="command">Add</button>
                <button id="addCancelBtn" type="button" data-bind="visible: $root.enableAdd, click : $root.closeAddControl" class="command">Cancel</button>
            </span>

            <span class="formRowSpacer"></span>

            </div>


            </script>











            <script type="text/html" id="companyEntityAddTemplate">

            <div class="form">

            <div class="formMainContent">

            <div class="sectionalFormHeader">Branch code</div>

            <div class="sectionalForm">
            <div class="leftSection">
            <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>Branch Code</div><div class="inputSectionBlock"><input
            class="validate[required, maxSize[10]]" type="text" data-bind="codepicker : code, codeEntity : { codeType : 14, companyId : $root.globalViewModel.companyId() }"
            id="BranchCode" name="BranchCode" placeholder="a new branch code"  /></div>
            </div>

            <div class="rightSection">
            <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
            id="Enabled" data-bind="checked : disabled" /></div>
            </div>
            </div>

            <div class="formRow">
            <div class="labelSectionBlockBold"><i class="icon-asterisk"></i>Branch Name</div><div class="inputSectionBlock"><input
            type="text" class="validate[required, maxSize[80]]" data-bind="value : name" id="BranchName" placeholder="a new branch name"/></div>
            </div>


            <div class="formRow">
            <div class="labelSectionBlock">Description</div><span class='req'>&nbsp;</span><div class="inputSectionBlock"><textarea
            type="text" class="validate[maxSize[80]]" id="Description" data-bind="value : description"
            placeholder="description for new branch"></textarea></div>
            </div>

            <div> <div class="maintenanceCommandSpace"></div>
            <div id="branchCommand" class="maintenanceCommand">
            <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
            class="command">Save</button>
            <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
            <button id="copy" type="button" data-bind="click : copy" class="command">Copy</button>
            <button id="paste" type="button" data-bind="click : paste" class="command">Paste</button>
            </div>
            </div>

            </div>

            <div>&nbsp;
            </div>
            <div>

            <div class="subHeader" data-bind="visible : showInfo"> Branch Info </div>

            <div class="formRowSpacer"></div>

            <div id="accordian" class="formRowAddContainer" data-bind="template : { name : 'infoAddTemplate'}, visible : (enableAdd && showInfo) "></div>

            <div class="formRowSpacer"></div>

            <div class="emptyData" data-bind="visible : ($root.listInfo().length == 0 && showInfo)">
            <div>
            <ul>


            <li class="emptyDataSpacer"> </li>
            <li> No data available.</li>
            </ul>
            </div>
            </div>


            <div class="formRowHeader" data-bind="visible : ($root.listInfo().length > 0 && showInfo)">
            <span class='columnDividerListView'>Category</span>
            <span class='columnDividerListView'>Description</span>
            <span class='columnDividerListView'>Type</span>
            <span class='columnDividerListView'>Value</span>
            <span class='columnDividerListViewCmd' data-bind='visible: $root.enableUpdate'>Edit</span>
            <span class='columnDividerListViewCmd' data-bind='visible: $root.enableDelete'>Delete</span>
            </div>


            <div class="formList" data-bind="visible : ($root.listInfo().length > 0 && enableUpdate) || ($root.listInfo().length > 0 && enableDelete),
            template : { name :  infoTemplateToUse, foreach : listInfo}"></div>

            </div>
            </div>

            </script>

            <script type="text/javascript">

                var vm;

                $(document).ready(function()
                {
                    var formName = "branchForm";
                    //var vm;
                    $.when(init()).done(bind());

                    function init()
                    {
                        vm = new BranchInfoViewModel(globalViewModel);
                    }

                    function bind()
                    {
                        $("#branchForm").setupViewBinding(vm, globalViewModel);
                        $("#accordian").accordion({collapsible : true, active: false});
                        $("#" + formName).validationEngine();
                    }
                });

            </script>

            <form id="branchForm">
                <div id="branchMaintenance" data-bind="template : { name : templateToUse} ">
            </div>
        </form>