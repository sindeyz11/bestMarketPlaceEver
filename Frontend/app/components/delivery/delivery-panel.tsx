import { DeliveryItemProps } from "@/components/delivery/interfaces";
import { DeliveryItem } from "@/components/delivery/delivery-item";

interface DeliveryPanelProps {
  codeForReceive: string;
  items?: DeliveryItemProps[];
}

export const DeliveryList = ({ codeForReceive, items }: DeliveryPanelProps) => {
  return (
    <div className="bg-white rounded-xl p-6">
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
            key={item.title}
            title={item.title}
            imgPath={item.imgPath}
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

// <DeliveryItem
//               title="Помидоры"
//               imgPath="./pomodoro.png"
//               price={250}
//               unit="кг"
//               count={2}
//               dateOrder="01.01.2023"
//               dateDelivery="01.01.2023"
//               status="отказ"
//             />
//             <DeliveryItem
//               title="Че-то"
//               price={250}
//               unit="кг"
//               count={2}
//               dateOrder="01.01.2023"
//               dateDelivery="01.01.2023"
//               status="отказ"
//             />
//             <DeliveryItem
//               title="Огурцы"
//               imgPath="./cucumbers.png"
//               price={250}
//               unit="кг"
//               count={2}
//               dateOrder="01.01.2023"
//               dateDelivery="01.01.2023"
//               status="отказ"
//             />
