import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class MetricsConversionServiceService {

    private static readonly POUNDS_PER_KILOGRAM: number = 2.20462;
    private static readonly OUNCES_PER_POUND: number = 16;

    constructor() { }

    public static convertWeight(metricsSystem: string, weight: number): number {
        if (metricsSystem.toLowerCase() === 'metric') {
            return weight;
        } else if (metricsSystem.toLowerCase() === 'imperial') {

        }
    }

    public static convertMetrictWeightToImperial(weight: number): string {
        const pounds: number = Math.trunc(weight * this.POUNDS_PER_KILOGRAM);
        const ounces: number = Math.trunc((weight * this.POUNDS_PER_KILOGRAM -
            Math.trunc(weight * this.POUNDS_PER_KILOGRAM)) * this.OUNCES_PER_POUND);
        return pounds + '\'' + ', ' + ounces + '"';
    }

    public static convertImperialWeightStringToMetric(weight: string): number {
        var kgWeight = 0;
        var weights = weight.match(/\d+/g).map(Number);
        if (weights.length > 0) {
            if (!isNaN(+weights[0])) {
                kgWeight += weights[0] / this.POUNDS_PER_KILOGRAM;
            }
        }
        if (weights.length > 1) {
            if (!isNaN(+weights[1])) {
                kgWeight = kgWeight + weights[1] / (this.POUNDS_PER_KILOGRAM + this.OUNCES_PER_POUND);
            }
        }

        console.log('Weight in kilograms: ' + kgWeight);
        return Math.trunc(kgWeight);

    }

    public static convertImperialWeightToMetric(pounds: number, ounces: number): number {
        let kilograms = pounds / this.POUNDS_PER_KILOGRAM;
        kilograms += (ounces / this.OUNCES_PER_POUND) / this.POUNDS_PER_KILOGRAM;
        return Math.trunc(kilograms);
    }
}
