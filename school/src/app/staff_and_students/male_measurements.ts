import { Measurements } from './measurements';

export class male_measurements implements Measurements {

    private readonly gender: string = "Male";
    private chestSize: number;
    private waistSize: number;
    private penisLength: number;
    private penisGirth: number;

    getMeasurementsForGender(gender: string): Measurements {
        if (gender.toLowerCase() === this.gender.toLowerCase()) {
            return this;
        } else {
            return null;
        }
    }

    public getChestSize(): number {
        return this.chestSize;
    }

    public getWaistSize(): number {
        return this.waistSize;
    }

    public getPenisLength(): number {
        return this.penisLength;
    }

    public getPenisGirth(): number {
        return this.penisGirth;
    }

    public setChestSize(chestSize: number) {
        this.chestSize = chestSize;
        return this;
    }



}
