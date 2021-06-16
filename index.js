import { NativeModules } from "react-native";

const { RNPowerManager } = NativeModules;

function isAppIgnoringBatteryOptimization() {
  return new Promise((resolve) => {
    RNPowerManager.isAppIgnoringBatteryOptimization((ignoringOptimization) => {
      resolve(ignoringOptimization);
    });
  });
}

// function getLocationPowerSaveMode() {
//   return new Promise((resolve) => {
//     RNPowerManager.getLocationPowerSaveMode((locationPowerSaveMode) => {
//       resolve(locationPowerSaveMode);
//     });
//   });
// }

function isPowerSaveMode() {
  return new Promise((resolve) => {
    RNPowerManager.isPowerSaveMode((isPowerSaveMode) => {
      resolve(isPowerSaveMode);
    });
  });
}

export {
  isAppIgnoringBatteryOptimization,
  //   getLocationPowerSaveMode,
  isPowerSaveMode,
};
