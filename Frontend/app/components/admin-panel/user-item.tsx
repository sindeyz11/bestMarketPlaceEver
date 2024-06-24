import { IUser } from "@/types";
import { formatNumber } from "@/utils";

export const UserItem = ({
  code,
  name,
  role,
  discount,
  redemptionSum,
}: Omit<IUser, "redemptionPercentage">) => {
  const formatId = (id: number) => {
    return id.toString().padStart(5, "0");
  };
  const generateId = (role: string, id: number): string => {
    if (role === "admin") return `AD-${formatId(id)}`;
    else if (role === "manager") return `MG-${formatId(id)}`;
    return `US-${formatId(id)}`;
  };
  return (
    <div className="flex items-center justify-between rounded-lg bg-secondary-bg p-4">
      <div className="flex flex-col gap-1">
        <h3 className="text-lg font-semibold">{name}</h3>
        <div className="flex flex-col leading-none">
          <span>{generateId(role ? role : "unknown", code)}</span>
          <span>{role}</span>
        </div>
      </div>
      <div className="flex flex-col items-end justify-between">
        <span className="text-xl font-medium">{discount}%</span>
        <span className="text-xl font-medium">
          ₽{formatNumber(redemptionSum)}
        </span>
      </div>
    </div>
  );
};
