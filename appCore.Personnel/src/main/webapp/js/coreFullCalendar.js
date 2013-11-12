(function () {
    ko.fullCalendar = {
        // Defines a view model class you can use to populate a calendar
        viewModel:function (configuration) {
            this.events = configuration.events;
            this.header = configuration.header;
            this.editable = configuration.editable;
            this.viewDate = configuration.viewDate || ko.observable(new Date());
        }
    };

    var calendar;
    // The "fullCalendar" binding
    ko.bindingHandlers.fullCalendar = {
        // This method is called to initialize the node, and will also be called again if you change what the grid is bound to
        update:function (element, viewModelAccessor) {
            var viewModel = viewModelAccessor();
            element.innerHTML = "";

                var calendar = $(element).fullCalendar({
                events:ko.utils.unwrapObservable(viewModel.events),
                header:viewModel.header,
                editable:viewModel.editable,
                selectable:true,
                selectHelper:true,
                select:function (start, end, allDay) {
                    var title = prompt('Event Title:');
                    if (title) {
                        calendar.fullCalendar('renderEvent',
                            {
                                title:title,
                                start:start,
                                end:end,
                                allDay:allDay
                            },
                            true // make the event "stick"
                        );
                    }
                    calendar.fullCalendar('unselect');
                },
                editable:true
            });
            $(element).fullCalendar('gotoDate', ko.utils.unwrapObservable(viewModel.viewDate));

        }
    };
})();