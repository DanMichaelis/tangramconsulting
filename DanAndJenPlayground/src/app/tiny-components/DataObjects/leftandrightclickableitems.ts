import { ClickableIcon } from './clickableicon';

export class LeftAndRightClickableItems {
    private left: ClickableIcon;
    private right: ClickableIcon;

    public constructor(leftClickableItem: ClickableIcon, rightClickableItem) {
        this.left = leftClickableItem;
        this.right = rightClickableItem;
    }

    public getLeft(): ClickableIcon {
        return this.left;
    }

    public getRight(): ClickableIcon {
        return this.right;
    }
}