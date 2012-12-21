var EmployeeExpertiseViewViewModel = function (dataSource) {

    var self = this;
    self.bindingSource = ko.observableArray(dataSource);

    self.remove = function (element) {
        self.initData.remove(element);
    }

}