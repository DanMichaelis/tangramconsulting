import { AppPreferences } from './configuration objects/apppreferences';

export class DashboardUser {
    login: string;
    firstName: string;
    lastName: string;
    email: string;
    phone: string;
    skypeId: string;
    preferences: AppPreferences;

    public constructor(userId: string, firstName: string, lastName: string, email: string) {
        this.login = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}