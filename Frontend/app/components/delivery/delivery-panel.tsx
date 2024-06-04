import { DeliveryItem } from "@/components/delivery/delivery-item";
import { IDeliveryItem } from "@/types";

interface DeliveryPanelProps {
  codeForReceive: string;
  items?: IDeliveryItem[];
}

export const DeliveryList = ({ codeForReceive, items }: DeliveryPanelProps) => {
  return (
    <div className="bg-white shadow-lg rounded-xl p-6">
      <div className="flex items-center justify-between">
        <h2 className="text-black font-semibold text-lg">
          Информация о доставках
        </h2>
        <div className="flex items-center gap-2">
          <p>Код для получения: </p>
          <span className="bg-secondary-text/10 font-semibold rounded-lg p-1.5">
            {codeForReceive}
          </span>
        </div>
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
        <div className="min-h-[500px] w-full text-center flex items-center justify-center">
          Информация о доставках отсутствует
        </div>
      )}
    </div>
  );
};
