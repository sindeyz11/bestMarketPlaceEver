import { Banner } from "@/components/layout/banner";
import { Filter } from "@/components/layout/filter";
import { ProductCard } from "@/components/layout/product-card";
import { Select } from "@/components/ui/select";

const HomePage = () => {
  return (
    <div>
      <Banner />
      <div className="px-20 py-12">
        <div className="flex items-center justify-between mb-6">
          <h3 className="text-2xl">Витрина магазина</h3>
          <span className="flex items-center gap-2 text-sm ">
            Сортировать по:
            <div className="w-48">
              <Select
                options={["Популярности", "Цене", "Алфавиту"]}
                size="small"
              />
            </div>
          </span>
        </div>
        <div className="flex items-start gap-20">
          <Filter
            minPrice={123}
            maxPrice={6000}
            categories={[
              { name: "Все категории", count: 500 },
              { name: "Категория 1", count: 100 },
              { name: "Помидоры", count: 150 },
              { name: "Огурцы", count: 50 },
              { name: "Категория 4", count: 200 },
            ]}
          />
          <div className="grid grid-cols-2 sm:grid-cols-3 xl:grid-cols-4 2xl:grid-cols-5 gap-5 w-full">
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./cucumbers.png"
              title="Огурцы"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./pomodoro.png"
              title="Подмидоры"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./pomodoro.png"
              title="Подмидоры"
              unit="кг"
              inStock={176}
              price={250}
            />
            <ProductCard
              imgPath="./pomodoro.png"
              title="Подмидоры"
              unit="кг"
              inStock={176}
              price={250}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
