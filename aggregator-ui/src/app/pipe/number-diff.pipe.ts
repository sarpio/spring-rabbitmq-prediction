import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'numberDiff'
})
export class NumberDiffPipe implements PipeTransform {

  transform(forecast: number, actual: number): number {
    const diff = forecast - actual;
    return parseFloat(diff.toFixed(3));
  }

}
