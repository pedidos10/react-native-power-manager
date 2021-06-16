export enum LocationPowerSaveMode {
  LOCATION_MODE_NO_CHANGE = 0,
  LOCATION_MODE_GPS_DISABLED_WHEN_SCREEN_OFF = 1,
  LOCATION_MODE_ALL_DISABLED_WHEN_SCREEN_OFF = 2,
  LOCATION_MODE_FOREGROUND_ONLY = 3,
  LOCATION_MODE_THROTTLE_REQUESTS_WHEN_SCREEN_OFF = 4,
}

export function isAppIgnoringBatteryOptimization(): Promise<boolean | null>;
// export function getLocationPowerSaveMode(): Promise<LocationPowerSaveMode>;
export function isPowerSaveMode(): Promise<boolean | null>;
