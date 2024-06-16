export interface IProduct {
  id: number;
  title: string;
  price: number;
  discountPrice: number;
  description: string;
  unit: string;
  availableQuantity: number;
  image: string;
  category?: string;
}

export interface IPickupPoint {
  code: string;
  address: string;
  manager: IUser;
  income: number;
}

export interface IUser {
  code: string;
  name: string;
  role: IUserRole;
  redemptionSum: number;
  redemptionPercentage: number;
  discount: number;
}

export interface IDeliveryItem extends Partial<IProduct> {
  count: number;
  dateOrder: string;
  dateDelivery: string;
  status?: "в пути" | "отказ" | "доставлено" | "получено";
}

export type IPositionItem = Partial<IProduct>;

export type IBannerProduct = Omit<IProduct, "unit" | "availableQuantity">;

export type IUserRole = "USER" | "ADMIN" | "MANAGER" | undefined;
