        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/divisionInfoViewModel.js"></script>
        <script language="javascript" src="../../js/jquery.validationEngine-en.js"></script>


        <script type="text/html" id="infoUpdateTemplate">

        <div class="formRowList">

        <span class='columnDivider'>
        <span class="labelSection">Category</span>
        <span class="inputSectionForm"><input type="text" data-bind="value : $root.infoCategory" placeholder="info type"/></span>

        </span>

        <span class='columnDivider'>
        <span class="labelSection">Description</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.infoDescription" placeholder="new description"/></span>
        </span>


        <span class='columnDivider'>
        <span class="labelSection">Type</span></span>
        <span class="inputSectionForm">
        <input type="text" data-bind="value : $root.infoType" placeholder="type"/></span>
        </span>

        <span class='columnDivider'>
        <span class="labelSection">Value</span>
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
        <div class="labelSection">Category</div>
        <div class="inputSectionForm"><input type="text"  data-bind="value : $root.addInfoCategory" placeholder="category type"/></div>

        </div>

        <div class='columnDivider'>
        <div class="labelSection">Description</div><span class='req'>*</span>
        <div class="inputSectionForm">
        <input type="text" data-bind="value : $root.addInfoDescription" placeholder="new description"/></div>
        </div>


        <div class='columnDivider'>
        <div class="labelSection">Type</div><span class='req'>*</span>
        <div class="inputSectionForm">
        <input type="text" data-bind="value : $root.addInfoType" placeholder="new type"/></div>
        </div>

        <div class='columnDivider'>
        <div class="labelSection">Value</div><span class='req'>*</span>
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


        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Division  Code</div><span class='req'>*</span><div class="inputSection"><input
        class="validate[required, maxSize[10]]" type="text" data-bind="value: code" id="DivisionCode" name="DivisionCode"
        placeholder="a new division code"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" data-bind="checked : disabled" /></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSection">Division Name</div><span class='req'>*</span><div class="inputSection"><input
        type="text" class="validate[required, maxSize[80]]" data-bind="value : name" id="DivisionName" placeholder="a new division name"/></div>
        </div>


        <div class="formRow">
        <div class="labelSection">Description</div><span class='req'>&nbsp;</span><div class="inputSection">
        <textarea class="validate[required, maxSize[80]]" id="Description" data-bind="value : description"></textarea></div>
        </div>

        <div> <div class="maintenanceCommandSpace"></div>
        <div id="divisionCommand" class="maintenanceCommand">
        <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
        class="command">Save</button>
        <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
        </div>
        </div>

        </div>

        <div>&nbsp;
        </div>


        <div>



        <div class="subHeader"> Division Info </div>

        <div class="formRowSpacer"></div>



        <div id="accordianDivision" class="formRowAddContainer" data-bind="template : { name : 'infoAddTemplate'}, visible : enableAdd "></div>


        <div class="formRowSpacer"></div>


        <div class="emptyData" data-bind="visible : $root.listInfo().length == 0">
        <div>
        <ul>


        <li class="emptyDataSpacer"> </li>
        <li> No data available.</li>
        </ul>
        </div>
        </div>



        <div class="formRowHeader" data-bind="visible : $root.listInfo().length > 0">
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

        var formName = "divisionForm";
        $(document).ready(function()
        {
            $("#" + formName).validationEngine();

                var vm = new DivisionInfoViewModel(globalViewModel);
                $("#divisionForm").setupViewBinding(vm, globalViewModel);
                $("#accordianDivision").accordion({collapsible : true, active: false});
        });

        </script>


        <form id="divisionForm">
        <div id="divisionMaintenance" data-bind="template : { name : templateToUse} ">
        </form>