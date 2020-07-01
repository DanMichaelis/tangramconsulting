import { Measurements } from './measurements';
import { ProfilePreferences } from './profilepreferences';
import { MetricsConversionServiceService } from '../services/metrics-conversion-service.service';

export class Profile {

    private name: string;
    private chromosomes: string;
    private gender: string;
    private birthYear: number;
    private birthMonth: number;
    private location: string;
    private age: string; // So that it can be manually over-ridden, should the student choose
    private height: number;  // in centemeters
    private weight: number;  // in kilograms
    private hairColor: string;
    private hairStyle: string;
    private eyeColor: string;
    private measurements: Measurements;
    private preferences: string[];
    private description: string;
    private limits: string[];
    private interests: string[];
    private year: string; // Freshman, Sophomore, Junior, Senior
    private profilePreferences: ProfilePreferences;


    constructor(name: string, chromosomes: string, gender: string,
        birthYear: number, birthMonth: number, location: string, age: string, height: string, weight: string, hairColor: string, hairStyle: string, eyeColor: string, description: string) {
        this.name = name;
        this.chromosomes = chromosomes;
        this.gender = gender;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.location = location;
        this.height = 0;
        this.weight = 0;

        // Age here
    }

    public getName(): string {
        return this.name;
    }
    public getChromosomes(): string {
        return this.chromosomes;
    }
    public getGender(): string {
        return this.gender;
    }
    public getBirthyear(): number {
        return this.birthYear;
    }
    public getBirthmonth(): number {
        return this.birthMonth;
    }
    public getLocation(): string {
        return this.location;
    }
    public getAge(): string {
        return this.age;
    }
    public getHeight(): string {
        return '' + this.height;
    }
    public getWeight(): string {
        return '' + this.weight;
    }
    public getHaircolor(): string {
        return this.hairColor;
    }
    public getHairstyle(): string {
        return this.hairStyle;
    }
    public getEyecolor(): string {
        return this.eyeColor;
    }
    public getMeasurements(): Measurements {
        return this.measurements;
    }
    public getPreferences(): string[] {
        return this.preferences;
    }
    public getDescription(): string {
        return this.description;
    }
    public getLimits(): string[] {
        return this.limits;
    }
    public getInterests(): string[] {
        return this.interests;
    }
    public getYear(): string {
        return this.year;
    }
    public getProfilePreferences(): ProfilePreferences {
        return this.profilePreferences;
    }
    public setName(name: string): Profile {
        this.name = name;
        return this;
    }
    public setChromosomes(chromosomes: string): Profile {
        this.chromosomes = chromosomes;
        return this;
    }
    public setGender(gender: string): Profile {
        this.gender = gender;
        return this;
    }
    public setBirthyear(birthYear: number): Profile {
        this.birthYear = birthYear;
        return this;
    }
    public setBirthmonth(birthMonth: number): Profile {
        this.birthMonth = birthMonth;
        return this;
    }
    public setLocation(location: string): Profile {
        this.location = location;
        return this;
    }
    public setAge(age: string): Profile {
        this.age = age;
        return this;
    }
    public setHeight(height: string): Profile {
        this.height = +height;
        return this;
    }
    public setWeight(weight: string): Profile {
        if (isNaN(+weight)) {
            this.weight = MetricsConversionServiceService.convertImperialWeightStringToMetric(weight);
        } else {
            this.weight = +weight;
        }
        return this;
    }
    public setHaircolor(hairColor: string): Profile {
        this.hairColor = hairColor;
        return this;
    }
    public setHairstyle(hairStyle: string): Profile {
        this.hairStyle = hairStyle;
        return this;
    }
    public setEyecolor(eyeColor: string): Profile {
        this.eyeColor = eyeColor;
        return this;
    }
    public setMeasurements(measurements: Measurements): Profile {
        this.measurements = measurements;
        return this;
    }
    public setPreferences(preferences: string[]): Profile {
        this.preferences = preferences;
        return this;
    }
    public setDescription(description: string): Profile {
        this.description = description;
        return this;
    }
    public setLimits(limits: string[]): Profile {
        this.limits = limits;
        return this;
    }
    public setInterests(interests: string[]): Profile {
        this.interests = interests;
        return this;
    }
    public setYear(year: string): Profile {
        this.year = year;
        return this;
    }
    public addLimit(limit: string): Profile {
        this.limits[this.limits.length + 1] = limit;
        return this;
    }
    public addInterest(interest: string): Profile {
        this.interests[this.interests.length + 1] = interest;
        return this;
    }
    public setProfilePreferences(preferences: ProfilePreferences): Profile {
        this.profilePreferences = preferences;
        return this;
    }
}
