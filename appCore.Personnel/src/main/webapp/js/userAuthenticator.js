var UserAuthenticator = function () {
    this.authenticateUser = function (username, password, callBack) {

        var $pem = "-----BEGIN PUBLIC KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiPFWSQ8SyhSPmZUEipn14PbVX+EG+I93H9WW2Ay4zHqxST/TnPihcPJnJJy7ADlooITCD91Z6mkg/bwBIoWzQAOlHcFOHxTBei6mgxfiDMSWAW77jeCmzOh8gMsBAHP9lWBpBOeqhf5Kao2DMmumVLcz4O2X1fYN88p+ICthLcQIDAQAB-----END PUBLIC KEY-----";
        var $key = RSA.getPublicKey($pem);

        var user = new User();
        user.Username = RSA.encrypt(username, $key);
        user.Password = RSA.encrypt(password, $key);

        var ajax = new AjaxCore();
        var request = ajax.sendRequest(globalUserAuthenticationUrl, user, "get");
        request.success(function (msg) {
            callBack(msg);
        });
    }
}