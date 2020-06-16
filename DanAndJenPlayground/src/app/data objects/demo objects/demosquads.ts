import { Squad } from '../squad';
import { DemoAvatars } from './demoavatars';
import { DemoMembers } from './demomembers';

export class DemoSquads {


    public static squad1 = (new Squad()).setName('Squad 1').setAvatar(DemoAvatars.femaleAvatar.setSize(35)).setType('Delivery').addMember(DemoMembers.Keshma, 'Product Owner').addMember(DemoMembers.Dan, 'Squad Member');
    public static squad2 = (new Squad()).setName('Squad 2').setAvatar(DemoAvatars.maleAvatar.setSize(35)).setType('Product').addMember(DemoMembers.Keshma, 'Product Owner');
    public static squad3 = (new Squad()).setName('Squad 3').setAvatar(DemoAvatars.productIcon.setSize(35)).setType('Delivery').addMember(DemoMembers.Sam, 'Product Owner').addMember(DemoMembers.Jen, 'Squad Member').addMember(DemoMembers.Dan, 'Squad Member').addMember(DemoMembers.Dan, 'Developer');
    public static squad4 = (new Squad()).setName('Squad 4').setAvatar(DemoAvatars.deliveryIcon.setSize(35)).setType('Support').addMember(DemoMembers.Dan, 'Product Owner').addMember(DemoMembers.Jen, 'Squad Member').addMember(DemoMembers.Sam, 'Squad Member').addMember(DemoMembers.Keshma, 'Another kind of member');
    public static squad5 = (new Squad()).setName('Squad 5').setAvatar(DemoAvatars.squad1Avatar.setSize(35)).setType('Support').addMember(DemoMembers.Dan, 'Squad Member').addMember(DemoMembers.Jen, 'Squad Member').addMember(DemoMembers.Sam, 'Squad Member');
}
