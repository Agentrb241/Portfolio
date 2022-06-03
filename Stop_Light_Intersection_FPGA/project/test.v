`timescale 1ns / 1ps


module test;

	// Inputs
	reg b_one;
	reg b_two;
	reg clk;

	// Outputs
	wire light_one;
	wire light_two;
	wire light_three;

	// Instantiate the Unit Under Test (UUT)
	street_lights uut (
		.b_one(b_one), 
		.b_two(b_two), 
		.clk(clk), 
		.light_one(light_one), 
		.light_two(light_two), 
		.light_three(light_three)
	);

	initial begin
		// Initialize Inputs
		b_one = 0;
		b_two = 0;
		clk = 0;
		
		forever begin
		#100000000 clk = ~clk;
		end

		// Wait 1 s for global reset to finish
		#100;
      
		// Add stimulus here

		b_one = 1;
		b_two = 1;
		
		#500000000;
		
		b_one = 1;
		b_two = 1;
		
		#500000000;
		
		b_one = 1;
		b_two = 1;
		
		
		
	end
      
endmodule

