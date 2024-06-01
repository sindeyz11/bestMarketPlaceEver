"use client";

import { useState } from "react";
import { CrossIcon } from "@/components/icons/cross-icon";
import { Field } from "@/components/ui/field";

interface FilterProps {
  minPrice: number;
  maxPrice: number;
  categories: Category[];
}

type Category = {
  name: string;
  count: number;
};

export const Filter = ({ minPrice, maxPrice, categories }: FilterProps) => {
  const [selectedCategories, setSelectedCategories] = useState<string[]>([]);

  const toggleCategory = (categoryName: string) => {
    setSelectedCategories((prevSelected) =>
      prevSelected.includes(categoryName)
        ? prevSelected.filter((name) => name !== categoryName)
        : [...prevSelected, categoryName],
    );
  };

  return (
    <div className="max-w-64 flex flex-col gap-6">
      <div className="flex flex-col gap-3">
        <h3 className="text-xl font-semibold uppercase">Подкатегории</h3>
        <div className="flex flex-col gap-2">
          {categories.map((category) => {
            const isSelected = selectedCategories.includes(category.name);
            return (
              <div
                key={category.name}
                className={`px-4 py-2 rounded-lg flex items-center justify-between cursor-pointer transition-colors ${
                  isSelected ? "bg-accent/35" : "bg-field-bg"
                }`}
                onClick={() => toggleCategory(category.name)}
              >
                <span className="font-semibold flex items-center gap-2">
                  {isSelected && <CrossIcon className="w-4 h-4" />}
                  {category.name}
                </span>
                <span className="font-semibold">{category.count}</span>
              </div>
            );
          })}
        </div>
      </div>
      <div className="flex flex-col gap-3">
        <h3 className="text-xl font-semibold uppercase">Цена</h3>
        <div className="flex items-center justify-between gap-4">
          <span>от</span>
          <Field
            variant="numeric"
            startContent="₽"
            placeholder={minPrice.toString()}
          />
          <span>до</span>
          <Field
            variant="numeric"
            startContent="₽"
            placeholder={maxPrice.toString()}
          />
        </div>
      </div>
    </div>
  );
};
