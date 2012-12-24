var GlobalViewModel = function ()
{
    var self = this;
    self.companyId = ko.observable();
    self.companyName = ko.observable();

    self.employeeRole = ko.observable();
    self.employeeId = ko.observable();

    self.targetId = ko.observable();
    self.editMode = ko.observable();
    self.applicationScopeType = ko.observable();

    /*
     Used to identified application specific target id.
     Allocated for future use.
     */

    self.targetId = ko.observable();
}