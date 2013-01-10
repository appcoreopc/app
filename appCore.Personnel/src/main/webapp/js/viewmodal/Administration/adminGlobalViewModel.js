var AdminGlobalViewModel = function ()
{
    var self = this;
    self.userName = ko.observable();
    self.userRole = ko.observable();

    self.targetId = ko.observable();
    self.editMode = ko.observable();
    self.applicationScopeType = ko.observable();

    /*
     Used to identified application specific target id.
     Allocated for future use.
     */

}