/*
var CodeMaintenance = function ()
{
    //this.nid = ko.observable();
    //this.name = ko.observable();
    //this.description = ko.observable();
    //this.startEffectiveDate = ko.observable();
    //this.endEffectiveDate = ko.observable();
    //this.disabled = ko.observable();
    //sthis.lastUpdate= ko.observable();

    this.nid = ko.observable("nid");
    this.name = ko.observable("name");
    this.description = ko.observable("description");
    this.startEffectiveDate = ko.observable("startdate");
    this.endEffectiveDate = ko.observable("enddate");
    this.disabled = ko.observable("disabled");
    this.lastUpdate= ko.observable("lastupdate");

    this.save = function()
    {
         alert(this.nid());
         alert(this.name());
    }
}

ko.applyBindings(new CodeMaintenance());
*/

var CodeMaintenance = function ()
{
    this.nid = ko.observable("nid");
    this.name = ko.observable("name");
    this.description = ko.observable("description");
    this.startEffectiveDate = ko.observable("startdate");
    this.endEffectiveDate = ko.observable("enddate");
    this.disabled = ko.observable("disabled");
    this.lastUpdate= ko.observable("lastupdate");
}