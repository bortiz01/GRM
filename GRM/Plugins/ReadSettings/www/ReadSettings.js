var cordova = require('cordova');

function ReadSettings() {
}

ReadSettings.prototype.read = function (arg0, success, error) {
  cordova.exec(success, error, "ReadSettings", "readDateAndTime", [arg0]);
};

ReadSettings.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.ReadSettings = new ReadSettings();
  return window.plugins.ReadSettings;
};

cordova.addConstructor(ReadSettings.install);
