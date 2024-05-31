export interface DeliveryItemProps {
  title: string;
  price: number;
  unit: string;
  count: number;
  imgPath?: string;
  status?: "в пути" | "отказ" | "доставлено" | "получено";
  dateOrder: string;
  dateDelivery: string;
}
