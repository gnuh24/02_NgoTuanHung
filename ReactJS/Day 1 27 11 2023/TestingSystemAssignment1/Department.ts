export default class Department{
    private id: number;
    private name: string;

	constructor(id: number, name: string) {
        this.id = id;
        this.name = name;
    }

   

    /**
     * Getter id
     * @return {number}
     */
	public getId(): number {
		return this.id;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public setId(value: number) {
		this.id = value;
	}


    /**
     * Getter name
     * @return {string}
     */
	public getName(): string {
		return this.name;
	}

    /**
     * Setter name
     * @param {string} value
     */
	public setName(value: string) {
		this.name = value;
	}
    

}

export let department = new Department(1, "A");
export function printIn4(department: Department) {
    console.log(`ID: ${department.getId()}, Name: ${department.getName()}`);
}
