Executor = (function ($, ko) {
    var executor = {};
    var commands = {};
    var postExecuteCommands = {};

    executor.clear = function () {
        commands.length = 0;
    }

    executor.newRegister = function (commandName, method) {
        executor.clear();
        var commandHandler =
        {
            ref:this,
            callback:method
        };
        commands[commandName] = commandHandler;
    };

    executor.register = function (commandName, method) {
        var commandHandler =
        {
            ref:this,
            callback:method
        };
        commands[commandName] = commandHandler;
    };

    executor.postRegister = function (commandName, method) {
        var commandHandler =
        {
            ref:this,
            callback:method
        };
        postExecuteCommands[commandName] = commandHandler;
    };

    executor.execute = function (commandName, data) {

        try {
            var cmd = commands[commandName];
            if (cmd) {
                cmd.callback.call(cmd.ref, data);
                cmd.callback();
            }
        }
        catch (ex) {
            console.log(ex.message);
        }
    };
    return executor;
})(jQuery, ko);
