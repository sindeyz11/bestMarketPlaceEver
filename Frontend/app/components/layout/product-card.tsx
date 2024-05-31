import { Button } from "@/components/ui/button";
import { Counter } from "@/components/ui/counter";

interface ProductCardProps {
  title: string;
  price: number;
  unit: string;
  inStock: number;
  imgPath?: string;
}

export const ProductCard = ({
  title,
  price,
  unit,
  inStock,
  imgPath = "./no-product.png",
}: ProductCardProps) => {
  return (
    <div className="group flex flex-col justify-center transition-all rounded-lg border border-transparent hover:border-black p-4 h-[30em]">
      <div className="p-2 mx-auto flex justify-center items-center h-72 w-full">
        <img
          src={imgPath}
          alt={title}
          className="h-full w-full object-contain"
        />
      </div>
      <span className="text-lg font-bold">{title}</span>
      <div className="flex items-center font-semibold gap-1.5">
        <span>1{unit}</span>
        <span className="group-hover:flex hidden">|</span>
        <span className="text-secondary-text group-hover:flex hidden">
          {inStock}
          {unit} в наличии
        </span>
      </div>
      <div className="flex flex-col gap-2">
        <span className="text-xl group-hover:text-3xl transition-all text-green-600 font-bold ">
          ₽
          {Intl.NumberFormat("ru", {
            style: "decimal",
            minimumFractionDigits: 2,
            maximumFractionDigits: 2,
          }).format(price)}
        </span>
        <div className="group-hover:hidden flex">
          <s className="text-xl text-secondary-text/50 font-bold">
            ₽
            {Intl.NumberFormat("ru", {
              style: "decimal",
              minimumFractionDigits: 2,
              maximumFractionDigits: 2,
            }).format(price)}
          </s>
        </div>
        <div className="hidden group-hover:flex items-center gap-2">
          <Counter />
          <Button size="small">Добавить</Button>
        </div>
      </div>
    </div>
  );
};
