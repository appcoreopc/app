(function ($) {
    $.fn.setupFullCalendar = function (calendarModel, globalViewModel) {
        var calendarControlId = "calendar";

        $(this).append('<div data-bind="fullCalendar: calendarViewModel"> </div>');
        //$(this).append('<button data-bind="click: function() { events.push({ title: &#39;New item&#39;, start: new Date(), allDay: false }); }">Add item</button>');

       /* var myModel = {
            items:ko.observableArray([
                {
                    title:'All Day Event',
                    start:new Date(y, m, 1)
                }
            ]),
            viewDate:ko.observable(Date.now())
        };*/

        calendarModel.calendarViewModel = new ko.fullCalendar.viewModel({
            events:calendarModel.items,
            header:{
                left:'prev,next today',
                center:'title',
                right:'month,agendaWeek,agendaDay'
            },
            editable:true,
            viewDate:calendarModel.viewDate
        });
        ko.applyBindings(calendarModel, document.getElementById('viewPort'));
    };

})(jQuery);