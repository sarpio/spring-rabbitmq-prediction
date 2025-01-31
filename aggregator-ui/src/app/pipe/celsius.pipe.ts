import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'celsius'
})
export class CelsiusPipe implements PipeTransform {

  transform(value: number, unit: string = '°C'): string {
    if (value === null || value === undefined) return '-';
    return `${value} ${unit}`;
  }

}
