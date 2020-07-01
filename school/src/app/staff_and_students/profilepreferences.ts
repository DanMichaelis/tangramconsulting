export class ProfilePreferences {

    private measurementStandard: string;

    constructor() { }

    public setMeasurementStandard(standard: string): ProfilePreferences {
        if (null === standard || standard.length === 0) {
            this.measurementStandard = 'Metric';
            return this;
        }

        if (standard.toLowerCase() === 'imperial') {
            this.measurementStandard = 'Imperial';
            return this;
        }

        this.measurementStandard = 'Metric';
        return this;
    }

}
