        <link href="../../css/company.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/dialogBox.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="../../css/entityJqueryUIOverride.css" media="screen" rel="stylesheet" type="text/css" />
        <script language="javascript" src="../../js/viewmodal/infoDataViewModel.js"></script>
        <script language="javascript" src="../../js/viewmodal/sectionInfoViewModel.js"></script>
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
        <div class="labelSectionInfo">Category</div>
        <div class="inputSectionForm"><input id="sectionCategoryAdd" type="text"  data-bind="value : $root.addInfoCategory"  class="validate[required, maxSize[10]]" placeholder="new category"/></div>

        </div>

        <div class='columnDivider'>
        <div class="labelSectionInfo">Description</div><span class='req'>*</span>
        <div class="inputSectionForm">
        <input type="text" data-bind="value : $root.addInfoDescription" placeholder="new description"/></div>
        </div>


        <div class='columnDivider'>
        <div class="labelSectionInfo">Type</div><span class='req'>*</span>
        <div class="inputSectionForm">
        <input id="sectionTypeAdd" type="text" data-bind="value : $root.addInfoType"  class="validate[required, maxSize[10]]" placeholder="new type"/></div>
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

        <div class="sectionalFormHeader">Section code</div>

        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSectionBlockBold">Section  Code</div><span class='req'>*</span><div class="inputSectionBlock"><input
        class="validate[required, maxSize[10]]" type="text" data-bind="codepicker : code, codeEntity : { codeType : 17, companyId : $root.globalViewModel.companyId() }"  id="SectionCode" name="SectionCode"
        placeholder="a new section code"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox"
        id="Enabled" data-bind="checked : disabled" /></div>
        </div>
        </div>

        <div class="formRow">
        <div class="labelSectionBlockBold">Section Name</div><span class='req'>*</span><div class="inputSectionBlock"><input
        type="text" class="validate[required, maxSize[80]]" data-bind="value : name" id="SectionName" placeholder="a new section name"/></div>
        </div>


        <div class="formRow">
        <div class="labelSectionBlock">Description</div><div class="inputSectionBlock"><textarea
        class="formTextArea" id="Description" data-bind="value : description"
        placeholder="description for new section"></textarea></div>
        </div>

        <div> <div class="maintenanceCommandSpace"></div>
        <div id="sectionCommand" class="maintenanceCommand">
        <button id="saveBtn" type="button" data-bind="visible : enableAdd || enableUpdate, click : updateData"
        class="command">Save</button>
        <button id="cancelBtn" type="button" data-bind="click : cancelUpdate" class="command">Cancel</button>
        </div>
        </div>


        </div>




        <div>&nbsp;
        </div>


        <div>

        <div class="subHeader" data-bind="visible : showInfo"> Section Info </div>

        <div class="formRowSpacer"></div>

        <div id="accordianSection" class="formRowAddContainer" data-bind="template : { name : 'infoAddTemplate'}, visible : (enableAdd && showInfo)"></div>


        <div class="formRowSpacer"></div>

        <div class="emptyData" data-bind="visible : ($root.listInfo().length == 0 && showInfo)">
        <div>
        <ul>


        <li class="emptyDataSpacer"> </li>
        <li> No data available.</li>
        </ul>
        </div>
        </div>


        <div class="formRowHeader" data-bind="visible : ( $root.listInfo().length > 0 && showInfo)">
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

        var formName = "sectionForm";

        $(document).ready(function()
        {
                var vm = new SectionInfoViewModel(globalViewModel);
                $("#sectionForm").setupViewBinding(vm, globalViewModel);
                $("#accordianSection").accordion({collapsible : true, active: false});
                $("#" + formName).validationEngine();
        });

        </script>

        <form id="sectionForm">
            <div id="sectionMaintenance" data-bind="template : { name : templateToUse} ">
            </div>
        </form>