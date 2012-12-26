var PermissionHelper = function ()
{
    this.getPermission = function (applicationId, roleId)
    {
        var input = { "id" : applicationId, "roleId" : roleId };
        var coreCommand = new CoreCommand();
        var result = coreCommand.getPermission(hostAuthorizationUrl, input);
    }

}