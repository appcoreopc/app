(function ($) {
    $.fn.setupSideBar = function (globalViewModel) {

        var globalCopy = "globalCopy";
        var globalPaste = "globalPaste";
        var globalPrint = "globalPrint";

        $(this).append('<li id="' + globalCopy + '"><i class="icon-doc-3"></i>Copy</li>');
        $(this).append('<li id="' + globalPaste + '"><i class="icon-doc-inv"></i>Paste</li>');
        $(this).append('<li id="' + globalPrint + '"><i class="icon-print-1"></i>Print</li>');

        function sendMessage(messageContent) {
            var message = { "messageType":coreMessageInfo, "message":messageContent}
            globalViewModel.message(message);
        }

        $("#" + globalCopy).click(function () {

            if (typeof vm !== 'undefined' && vm.copy) {
                vm.copy();
                sendMessage('Copied successfully.');
            }
            else {
                sendMessage('copy method not supported.');
            }
        });

        $("#" + globalPaste).click(function () {
            if (typeof vm !== 'undefined' && vm.paste) {
                vm.paste();
                sendMessage('Paste operation executed.');
            }
            else {
                sendMessage('paste method not supported.');
            }
        });

        $("#" + globalPrint).click(function () {
            if (typeof vm !== 'undefined' && vm.print) {
                vm.print();
                sendMessage('Printing. please wait..');
            }
            else {
                sendMessage('print method not supported.');
            }
        });


    };

})(jQuery);