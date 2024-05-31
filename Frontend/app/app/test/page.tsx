"use client";

import { AdminPanelIcon } from "@/components/icons/admin-panel-icon";
import { PhoneIcon } from "@/components/icons/phone-icon";
import { Button } from "@/components/ui/button";
import { Field } from "@/components/ui/field";
import { Select } from "@/components/ui/select";

const TestPage = ({}) => {
  return (
    <div className="flex flex-col gap-2">
      <div className="w-1/3">
        <Select options={["Опция 1", "Опция 2"]} size="small" />
      </div>
      <Button onClick={() => console.log("Яркая кнопка")}>Яркая кнопка</Button>
      <Button color="dark" onClick={() => console.log("Кнопка потемнее")}>
        Кнопка потемнее
      </Button>
      <Button
        variant="icon"
        icon={<AdminPanelIcon />}
        onClick={() => console.log("Кнопка-иконка")}
      />

      <Button variant="link" href="/">
        Ссылка
      </Button>

      <Field placeholder="Просто поле ввода" />
      <Field placeholder="Недоступно для ввода поле (disabled)" disabled />
      <Field
        placeholder="Просто поле ввода c неизменным контентом"
        startContent="₽"
      />
      <Field placeholder="Просто поле с иконкой" icon={<AdminPanelIcon />} />
      <Field
        placeholder="Просто поле с иконкой"
        icon={<PhoneIcon />}
        startContent="+7"
      />

      <Field variant="numeric" placeholder="500" startContent="₽" />
      <Field variant="numeric" placeholder="500" />

      <Field variant="textarea" placeholder="500" />
    </div>
  );
};

export default TestPage;
