import { faGenderless } from '@fortawesome/free-solid-svg-icons';

export interface Measurements {
    // Marker interface for male or female measurements
    getMeasurementsForGender(gender: string): Measurements;
}