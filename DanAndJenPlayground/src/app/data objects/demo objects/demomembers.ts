import { Member } from '../member';
import { DemoAvatars } from './demoavatars';

export class DemoMembers {


    public static readonly Dan = (new Member()).setFirstName('Daniel').setMiddleName('C').setLastName('Michaelis').setEmail('dan.michaelis@perficient.com').setSkypeId('dan.michaelis@perficient.com').setPhoneNumber('(407) 758-3395').setTitle('Sr. Technical Architect').setAvatar(DemoAvatars.maleAvatar);
    public static readonly Jen = (new Member()).setFirstName('Jennifer').setMiddleName(null).setLastName('Siegfried').setEmail('jennifer.siegfried@perficient.com').setSkypeId('jennifer.siegfried@perficient.com').setPhoneNumber('(212) 555-5555').setTitle('Agency Manager').setAvatar(DemoAvatars.femaleAvatar);
    public static readonly Keshma = (new Member()).setFirstName('Keshma').setMiddleName(null).setLastName('Hardy').setEmail('khardy@dtcc.com').setSkypeId('khardy@dtcc.com').setPhoneNumber('(813) 470-2506').setTitle('Product Owner').setAvatar(DemoAvatars.femaleAvatar);
    public static readonly Sam = (new Member()).setFirstName('Samantha').setMiddleName(null).setLastName('Kuzava').setEmail('skuzava@dtcc.com').setSkypeId('skuzava@dtcc.com').setPhoneNumber('(813) 470-1479').setTitle('Angular Technical Architect').setAvatar(DemoAvatars.femaleAvatar);
}