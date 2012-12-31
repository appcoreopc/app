    <link href="../../css/themes/base/jquery.ui.all.css" media="screen" rel="stylesheet" type="text/css" />

    <script type="text/javascript">

        $(document).ready(function()
        {
            var tab = $("#codeSetupTabs").tabs({ cache : true});

        });

    </script>

    <form id="myform">

    <div class="form">



        <div class="sectionalForm">
        <div class="leftSection">
        <div class="labelSection">Job</div><span class='req'>*</span><div class="inputSection">
        <input class="validate[required, maxSize[10]]" type="text" id="JobCode" name="JobCode" value="JobCode"/></div>
        </div>

        <div class="rightSection">
        <div class="inlineLabelSection">Disabled </div><div class="inlineLabelSection"><input type="checkbox" id="Enabled" /></div>
        </div>
        </div>



        <div class="formRow">
            <div class="labelSection">Job Title</div><span class="fieldSpacer"></span><div class="inputSection">
        <input type="text" id="JobTitle" class="validate[required, maxSize[80]]" value="JobTitle"/></div>
        </div>

        <div class="formRow">
            <div class="labelSection">Job Category</div><span class="fieldSpacer"></span><div class="inputSection">
        <input type="text" id="JobCategory" class="validate[required, maxSize[80]]" value="JobCategory"/></div>
        </div>


        <div class="formRow">
        &nbsp;
        </div>



        <div id="codeSetupTabs">
        <ul>
            <li><a href="jobDescriptionAdd.jsp">Job Description</a></li>
            <li><a href="jobQualificationAdd.jsp">Qualification Requirement</a></li>
            <li><a href="jobExperienceAdd.jsp">Experience Requirement</a></li>
            <li><a href="jobSkillRequirementAdd.jsp">Skill Requirement</a></li>
        </ul>


    </div>

    </div>
    </form>