using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Program
{
    static void Main()
    {
        string inputFilePath = "../words.txt";
        string outputFilePath = "../result_dotnet.csv";

        string[] lines = File.ReadAllLines(inputFilePath);

        var wordFreq = lines
            .SelectMany(line => line.Split(
                new char[] { ' ', '.', ',', ';', ':', '-', '!', '?' },
                 StringSplitOptions.RemoveEmptyEntries))
            .GroupBy(word => word.ToLower())
            .OrderByDescending(group => group.Count())
            .Select(group => $"{group.Key};{group.Count()};");

        File.WriteAllLines(outputFilePath, wordFreq);
    }
}
