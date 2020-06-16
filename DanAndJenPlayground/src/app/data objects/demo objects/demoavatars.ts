import { ClickableIcon } from 'src/app/tiny-components/DataObjects/clickableicon';

export class DemoAvatars {

    public static jenkinsAvatar = ClickableIcon.getAvatarIcon('Sample 1', '12345', 'Jenkins', null, 'assets/Jenkins.png', 35);
    public static avatar2 = ClickableIcon.getAvatarIcon('Sample 2', null, null, null, 'assets/puzzle.png', 35);
    public static femaleAvatar = ClickableIcon.getAvatarIcon('Sample 4', 'Generic Female Avatar', 'fbar@dtcc.com', 'Generic Female Avatar', 'assets/FemaleAvatar.png', 35);
    public static maleAvatar = ClickableIcon.getAvatarIcon('Sample 4', null, null, null, 'assets/MaleAvatar.png', 35);
    public static squad1Avatar = ClickableIcon.getImageIcon('Squad 1', 'Squad 1 Icon', 'assets/SquadIcon.png');
    public static squad2Avatar = ClickableIcon.getImageIcon('Squad 2', 'Squad 2 Icon', 'assets/TankSquadIcon.jpg');
    public static supportIcon = ClickableIcon.getImageIcon('Support', 'Support Icon', 'assets/SupportIcon.png');
    public static deliveryIcon = ClickableIcon.getImageIcon('Delivery', 'Delivery Icon', 'assets/Puzzle.png');
    public static productIcon = ClickableIcon.getImageIcon('Product', 'Product Icon', 'assets/ProductIcon.png');
    public static addIcon = ClickableIcon.getImageIcon('Add', 'Add Icon', 'assets/AddIcon.png');

    public static tribeIcon = ClickableIcon.getImageIcon('Edit', 'EditIcon', 'assets/TribeIcon.jpg');
    public static pencilIcon = ClickableIcon.getClassBasedICon('Edit FA pencil', 'fa fa-pencil', 'Edit');


    public static readonly editIcon = ClickableIcon.getClassBasedICon('Pencil FontAwesome Icon', 'fa fa-pencil', 'Edit');
    public static readonly skypeIcon = ClickableIcon.getClassBasedICon('Skype FontAwesome Icon', 'fa fa-skype', 'Skype Call');
    public static readonly emailIcon = ClickableIcon.getClassBasedICon('Envelope FontAwesome Icon', 'fa fa-envelope', 'Send Email');
    public static readonly membersIcon = ClickableIcon.getClassBasedICon('People Group FontAwesome Icon', 'fa fa-users', 'Group of People');
    public static readonly diamondIcon = ClickableIcon.getClassBasedICon('Diamond FontAwesome Icon', 'fa fa-diamond', 'Diamond');
}