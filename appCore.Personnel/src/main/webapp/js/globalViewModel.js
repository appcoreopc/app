var GlobalViewModel = function () {

    var self = this;

    self.companyId = ko.observable();
    self.companyName = ko.observable();

    self.employeeRole = ko.observable();
    self.employeeId = ko.observable();
    self.username = ko.observable();
    self.userId = ko.observable();

    self.targetId = ko.observable();
    self.editMode = ko.observable();
    self.applicationScopeType = ko.observable();
    self.refresh = ko.observable();

    // notification indicator like facebook
    self.notifications = ko.observable();

    self.message = ko.observable();

    self.recentItem = ko.observable();

    self.bindedViewModel = ko.observable();

    self.bindedControlId = ko.observable();

    self.isCopiedItem = ko.observable();

    self.copiedItem = ko.observable();

    self.showStatus = function (message, functionCall) {

    }

    self.addToRecentItem = function () {

        var recentItem = new RecentItemModel();
        recentItem.applicationScopeType = self.applicationScopeType();
        recentItem.editMode = self.editMode();
        recentItem.companyName = self.companyName();
        recentItem.companyId = self.companyId();
        recentItem.targetId = self.targetId();
        self.recentItem(recentItem); // notify change
    }

    self.setViewModel = function (viewModel) {
        if (viewModel != undefined)
            self.bindedViewModel(viewModel);
    }

}