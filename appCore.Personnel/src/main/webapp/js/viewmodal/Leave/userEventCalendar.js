/*
 $('div').tooltip(); // calls the init method
 $('div').tooltip({  // calls the init method
 foo : 'bar'
 });
 $('div').tooltip('hide'); // calls the hide method
 $('div').tooltip('update', 'This is the new tooltip content!'); // calls the update method
 */
(function ($) {
    var methods = {
        init:function (options) {
        },
        addEvents:function () {
            alert('addevent');
        },
        getEvents:function () {
            alert('getevents');
        },
        show:function (options) {
            var calendarControlId = "calendar";
            var element = $(this).append('<div id=' + calendar + '> </div>');

            var calendar = $(element).fullCalendar({
                events:options.events,
                header:options.header,
                editable:options.editable,
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
            $(element).fullCalendar('gotoDate', options.viewDate);

        },
        hide:function () {
            alert('hide');
        },
        update:function (content) {
            alert('update');
        }
    };

    $.fn.loadUserEventCalendar = function (methodOrOptions) {
        // These are the defaults.
        var settings = $.extend({
            events:[],
            viewDate:Date.now(),
            header:{
                left:'prev,next today',
                center:'title',
                right:'month,agendaWeek,agendaDay'
            },
            editable:true,
            selectable:true,
            selectHelper:true
        }, methodOrOptions);

        if (methods[methodOrOptions]) {
            return methods[ methodOrOptions ].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof methodOrOptions === 'object' || !methodOrOptions) {
            // Default to "init"
            return methods.show.apply(this, arguments);
        } else {
            $.error('Method ' + method + ' does not exist on jQuery.tooltip');
        }
    };
})(jQuery);