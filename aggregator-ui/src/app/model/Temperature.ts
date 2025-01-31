import {Data} from '@angular/router';

export interface Temperature {
  id: number;
  locationName: string;
  locationCountry: string;
  lastUpdate: Data;
  temperature: number;
  temperatureForecast: number;
}
