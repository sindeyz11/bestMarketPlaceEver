import { DeliveryItem } from "@/components/delivery/delivery-item";
import { IDeliveryItem } from "@/types";

interface DeliveryPanelProps {
  codeForReceive: string;
  items?: IDeliveryItem[];
}

export const DeliveryList = ({ codeForReceive, items }: DeliveryPanelProps) => {
  return (
    <div className="rounded-xl bg-white p-6 shadow-lg">
      <div className="flex items-center justify-between">
        <h2 className="text-lg font-semibold text-black">
          Информация о доставках
        </h2>
      </div>
      {items ? (
        items.map((item) => (
          <DeliveryItem
            id={item.id}
            discountPrice={item.discountPrice}
            description={item.description}
            availableQuantity={item.availableQuantity}
            key={item.title}
            title={item.title}
            image={item.image}
            price={item.price}
            unit={item.unit}
            count={item.count}
            dateOrder={item.dateOrder}
            dateDelivery={item.dateDelivery}
            status={item.status}
          />
        ))
      ) : (
        <div className="flex min-h-[500px] w-full items-center justify-center text-center">
          Информация о доставках отсутствует
        </div>
      )}
    </div>
  );
};
