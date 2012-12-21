var CodeMaintenance = function ()
{
    this.nid = ko.observable();
    this.name = ko.observable();
    this.description = ko.observable();
    this.startEffectiveDate = ko.observable();
    this.endEffectiveDate = ko.observable();
    this.disabled = ko.observable();
    this.lastUpdate= ko.observable();
}

 ko.applyBinding(new CodeMaintenance());

var IndustryCodeViewModel = function ()
{
    function industrySaveForm()
    {
        var codeProvider = new CoreCodeProvider();
        var code = new Industry();
        var code = codeProvider.getFormData(industry);
        sendSaveRequestToServer(code);
    }

    function sendSaveRequestToServer(data)
    {
    //        var request = ajaxCore.sendRequestType(globalHostname + "/app/Job/JobType/add", code, "post");
    //        request.success(function (data, status, xhrObj) {
    //            status = true;
    //       });
    //       if (status)
    //          preparePageForLoading("jobSetup.jsp");
    }
}

// CoreCodeProvider provide
var CoreCodeProvider = function()
{

    this.getFormData = function(entityObject)
    {
        entityObject = resetObject(entityObject);
        // reset the value back in //
        entityObject.name = $("#Name").val();
        entityObject.description = $("#Description").val();
        entityObject.startEffectiveDate = $("#StartEffectiveDate").val();
        entityObject.endEffectiveDate = $("#EndEffectiveDate").val();
        entityObject.disabled = $("#Disabled").val();
        entityObject.lastUpdate = $("#LastUpdate").val();

        return entityObject;
    }

    this.setFormData(entityObject)
    {
        $("#Name").val(entityObject.name);
        $("#Description").val(entityObject.description);
        $("#StartEffectiveDate").val(entityObject.startEffectiveDate);
        $("#EndEffectiveDate").val(entityObject.endEffectiveDate);
        $("#Disabled").val(entityObject.disabled);
        $("#LastUpdate").val(entityObject.lastUpdate);
    }

    function resetObject(entityObject)
    {
        // remove object properties
        delete entityObject.name;
        delete entityObject.description;
        delete entityObject.startEffectiveDate;
        delete entityObject.endEffectiveDate;
        delete entityObject.disabled;
        delete entityObject.lastUpdate;

        return entityObject;
    }
}